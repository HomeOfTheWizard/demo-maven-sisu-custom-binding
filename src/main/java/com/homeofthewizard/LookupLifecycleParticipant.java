package com.homeofthewizard;

import com.google.inject.AbstractModule;
import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.MavenExecutionException;
import org.apache.maven.execution.MavenSession;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.repository.exception.ComponentLookupException;
import org.codehaus.plexus.configuration.PlexusConfigurationException;
import org.eclipse.sisu.inject.Guice4;

import javax.inject.Named;
import javax.inject.Singleton;

@Named("lookupBean")
@Singleton
public class LookupLifecycleParticipant extends AbstractMavenLifecycleParticipant
{

    @Override
    public void afterSessionStart( MavenSession session )
            throws MavenExecutionException
    {
        try {
            System.out.println("LOOKUP Module: " + session.getContainer().lookup(AbstractModule.class,"myModule"));
            System.out.println("LOOKUP realm: " + session.getContainer().hasComponent("myComponent"));
        } catch (ComponentLookupException e) {
            throw new RuntimeException(e);
        }
        System.out.println("session started");
    }


    @Override
    public void afterProjectsRead( MavenSession session )
            throws MavenExecutionException
    {
        System.out.println("project read");
    }

}