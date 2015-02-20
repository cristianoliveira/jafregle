Jafregle 
=====================
[![Build Status](https://travis-ci.org/CristianOliveiraDaRosa/jafregle.svg?branch=master)](https://travis-ci.org/CristianOliveiraDaRosa/jafregle)
---
Java Free Google Translate or Jafregle

Simple unofficial free google translate library. 

#How it works?

You can create your own Translator. But by default it uses an alternative google url to request the translate that's why this lib may have performance issues. This Translator is recommended to use only in prototypes applications. 

###Is it free?

Using FreeGoogleTranslator, yes.
But it depends of the translator that you will use.

###Should I use it in my Production Application?

Yes. You can start using it in a Prototype after you can create your official translator using the Google Translator API for example.

#Using
More simple than that?

You can build the project with gradle.

```   
    git clone git@github.com:CristianOliveiraDaRosa/jafregle.git

    cd jafregle

    gradle clean build test
```

The jar is going to build inside of "build" folder.

Add the jar in your project and use:

```

 Jafregle j = new Jafregle(Jafregle.Language.ENGLISH, Jafregle.Language.PORTUGUESE); 
         
 String result = j.translate("Hello world!")

//result = Olá mundo.

```

##How to contribute?

Fork this repository implement a new Translator/Feature and do a push. Easy.

**IMPORTANT: For new features only will be accepted push with Unit Tests.

For new Translators only set it here:
JafregleTest.class
```
   @Before
    public void setTranslatorsToTest()
    {
    	translators.add(new FreeGoogleTranslator());
    	translators.add(new YourNewTranslator());
    }
``


License
====
  This project is under the Apache License, Version 2.0

Authors
====  
Cristian Oliveira - www.cristianoliveira.com.br
