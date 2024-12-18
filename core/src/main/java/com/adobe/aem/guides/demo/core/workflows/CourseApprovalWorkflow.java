package com.adobe.aem.guides.demo.core.workflows;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

@Component(service = WorkflowProcess.class, immediate = true, property = {
        "process.label=" + "CourseApprovalWorkflow"
})
public class CourseApprovalWorkflow implements WorkflowProcess {

    private static final Logger LOG = LoggerFactory.getLogger(CourseApprovalWorkflow.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
        String payloadType = workItem.getWorkflowData().getPayloadType();
        
        // Check if the payload is a JCR path
        if ("JCR_PATH".equals(payloadType)) {
            String path = workItem.getWorkflowData().getPayload().toString();
            LOG.info("Processing path: {}", path);

            try {
                // Get the resource corresponding to the JCR path
                ResourceResolver resourceResolver = workflowSession.adaptTo(ResourceResolver.class);
                if (resourceResolver != null) {
                    Resource resource = resourceResolver.getResource(path);
                    if (resource != null) {
                        // Approve the course
                        approveCourse(resource);
                    } else {
                        LOG.error("Resource not found at path: {}", path);
                    }
                } else {
                    LOG.error("ResourceResolver could not be obtained.");
                }
            } catch (Exception e) {
                LOG.error("Error processing workflow", e);
                throw new WorkflowException("Error processing workflow", e);
            }
        } else {
            LOG.error("Unsupported payload type: {}", payloadType);
            throw new WorkflowException("Unsupported payload type: " + payloadType);
        }
    }

    private void approveCourse(Resource courseResource) {
        try {
            Node courseNode = courseResource.adaptTo(Node.class);
            if (courseNode != null && courseNode.hasProperty("approvalStatus")) {
                courseNode.setProperty("approvalStatus", "approved");
                courseNode.getSession().save();
                LOG.info("Course approved successfully: {}", courseResource.getPath());
            } else {
                LOG.warn("Course resource does not have 'approvalStatus' property.");
            }
        } catch (RepositoryException e) {
            LOG.error("Error approving course: {}", courseResource.getPath(), e);
        }
    }
}
