Jafregle 
=====================
[![Build Status](https://travis-ci.org/CristianOliveiraDaRosa/jafregle.svg?branch=master)](https://travis-ci.org/CristianOliveiraDaRosa/jafregle)
---
Java Free Google Translate or Jafregle

Simple unofficial free google translate library.

#How it works?

It uses an alternative google url to request the translate that's why this lib may have performance issues. 
Recommended to use only in prototypes applications. 

###Is it free?

Yes.

###Should I use it in my Production Application?

Maybe. You need performance?


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
         
 j.translate("Hello world!")

//Output: Olá mundo.

```

License
====
  This project is under the Apache License, Version 2.0

Authors
====  
Cristian Oliveira - www.cristianoliveira.com.br
