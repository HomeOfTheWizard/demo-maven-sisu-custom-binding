# What is it ?

A maven extension containing a [custom Guice module](https://eclipse-sisu.github.io/sisu-project/plexus/index.html#custombinding) to be used in Maven's dependency injection mechanism, [Sisu](https://eclipse.dev/sisu/). 

# How to use it ?

This guice module is packaged as a maven extension,  
so in order to activate the extension you should put its artifact name in the `.mvn/extension.xml` file of the maven application you want to use it.
example: 
```
<extensions xmlns="http://maven.apache.org/EXTENSIONS/1.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/EXTENSIONS/1.0.0 http://maven.apache.org/xsd/core-extensions-1.0.0.xsd">
	<extension>
		<groupId>com.homeofthewizard</groupId>
		<artifactId>demo-maven-sisu-custom-binding</artifactId>
		<version>1.0-SNAPSHOT</version>
	</extension>
</extensions>
```

Then you can easily use the objects coming from the custom binding. 
example:
```
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
```
To see in more detail how to inject objects from guice-sisu into your plugins, see this [documentation](https://maven.apache.org/maven-jsr330.html)
