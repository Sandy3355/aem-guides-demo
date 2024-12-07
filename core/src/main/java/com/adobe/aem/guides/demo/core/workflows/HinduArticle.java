package com.adobe.aem.guides.demo.core.workflows;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class, immediate = true, 
           property = {"process.label=HinduArticle03122024"})
public class HinduArticle implements WorkflowProcess {

    private static final Logger LOG = LoggerFactory.getLogger(HinduArticle.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
        String payLoad = workItem.getWorkflowData().getPayloadType();

        if ("JCR_PATH".equals(payLoad)) {
            LOG.info("Payload: {}", payLoad);

            String path = workItem.getWorkflowData().getPayload().toString();
            LOG.info("Path: {}", path);
        }
    }
}
