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
        "process.label=" + "BlogPostApprovalWorkflow"
})
public class BlogPostApprovalWorkflow implements WorkflowProcess {

    private static final Logger LOG = LoggerFactory.getLogger(BlogPostApprovalWorkflow.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
        String payloadType = workItem.getWorkflowData().getPayloadType();
        
        // Check if the payload is a JCR path (i.e., the resource location in the repository)
        if ("JCR_PATH".equals(payloadType)) {
            String path = workItem.getWorkflowData().getPayload().toString();
            LOG.info("Processing path: {}", path);

            try {
                // Get the resource corresponding to the JCR path
                ResourceResolver resourceResolver = workflowSession.adaptTo(ResourceResolver.class);
                if (resourceResolver != null) {
                    Resource resource = resourceResolver.getResource(path);
                    if (resource != null) {
                        // Check if the resource is a blog post and approve it
                        approveBlogPost(resource);
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

    private void approveBlogPost(Resource blogPostResource) {
        try {
            Node blogPostNode = blogPostResource.adaptTo(Node.class);
            if (blogPostNode != null && blogPostNode.hasProperty("approvalStatus")) {
                // Set the approval status of the blog post to "approved"
                blogPostNode.setProperty("approvalStatus", "approved");
                blogPostNode.getSession().save();
                LOG.info("Blog post approved successfully: {}", blogPostResource.getPath());
            } else {
                LOG.warn("Blog post resource does not have 'approvalStatus' property.");
            }
        } catch (RepositoryException e) {
            LOG.error("Error approving blog post: {}", blogPostResource.getPath(), e);
        }
    }
}