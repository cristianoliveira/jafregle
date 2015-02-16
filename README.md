Jafregle
=====================
Java Free Google Translate or Jafregle

Simple unofficial free google translate library.

More simple than that?

#Cloning and Building

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
         
 j.translate("Hello world!")

//Output: Olá mundo.

```

License
====
  This project is under the Apache License, Version 2.0

Authors
====  
Cristian Oliveira - www.cristianoliveira.com.br
