Jafregle
=====================
Java Free Google Translate ou Jafregle

Simple unoficial free google translate lib.

Cloning and Building
====

You can build the project with gradle.

```
 git clone git@github.com:CristianOliveiraDaRosa/jafregle.git

 cd jafregle

 gradle buildJar

```

The jar is going to build inside of "build" folder.

Add the jar in your project and use:
```
Jafregle.translate("Hello world!", Jafregle.Language.ENGLISH, Jafregle.Language.PORTUGUESE)

//Output: Olá mundo.

```

License
====
  Copyright (c) 2010-2014 Primous Soluções Inteligentes. http://primous.com.br


	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in
	all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.

Authors
====  
Cristian Oliveira - www.cristianoliveira.com.br
