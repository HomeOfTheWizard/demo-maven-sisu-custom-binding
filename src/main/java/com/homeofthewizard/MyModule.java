package com.homeofthewizard;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import javax.inject.Named;

@Named("myModule")
public class MyModule extends AbstractModule {

    @Override
    public void configure() {
        bind(MyComponent.class).annotatedWith(Names.named("myComponent")).toInstance(new MyComponent());
    }
}
