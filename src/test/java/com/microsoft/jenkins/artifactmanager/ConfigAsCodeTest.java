package com.microsoft.jenkins.artifactmanager;

import com.cloudbees.plugins.credentials.CredentialsProvider;
import com.microsoftopentechnologies.windowsazurestorage.helper.AzureCredentials;
import hudson.model.Item;
import hudson.security.ACL;
import io.jenkins.plugins.casc.ConfigurationAsCode;
import jenkins.model.ArtifactManagerConfiguration;
import jenkins.model.ArtifactManagerFactory;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConfigAsCodeTest {
    @Rule
    public JenkinsRule j = new JenkinsRule();

    @Test
    public void config() throws Exception {
        ConfigurationAsCode.get().configure(this.getClass().getResource("/configuration-as-code1.yml").toString());

        List<AzureCredentials> azureCredentials = CredentialsProvider.lookupCredentials(
                AzureCredentials.class,
                (Item) null,
                ACL.SYSTEM,
                Collections.emptyList());
        for (AzureCredentials credentials : azureCredentials) {
            System.out.println(credentials);
        }
//        List<ArtifactManagerFactory> artifactManagerFactories = ArtifactManagerConfiguration.get().getArtifactManagerFactories();
//        assertEquals(1, artifactManagerFactories.size());
//        AzureArtifactManagerFactory managerFactory = (AzureArtifactManagerFactory) artifactManagerFactories.get(0);
//        System.out.println(managerFactory.getClass());
//        System.out.println(AzureArtifactConfig.get().getContainer());
//        System.out.println(AzureArtifactConfig.get().getPrefix());
    }
}
