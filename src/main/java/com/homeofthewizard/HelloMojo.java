package com.homeofthewizard;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import javax.inject.Inject;

@Mojo(name = "hello", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class HelloMojo extends AbstractMojo {

    private final MyHelloer helloer;

    @Inject
    public HelloMojo(MyHelloer helloer) {
        this.helloer = helloer;
    }

    public void execute() {
        helloer.hello();
    }

}
