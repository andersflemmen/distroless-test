# distroless-test

The image built with Maven by Jib in this example crashes with the following output in OpenShift:
```
Verifying certificates...
/etc/ssl/certs/java exists, listing files:
Exception in thread "main" java.nio.file.AccessDeniedException: /etc/ssl/certs/java
	at java.base/sun.nio.fs.UnixException.translateToIOException(UnixException.java:90)
	at java.base/sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:111)
	at java.base/sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:116)
	at java.base/sun.nio.fs.UnixFileSystemProvider.newDirectoryStream(UnixFileSystemProvider.java:432)
	at java.base/java.nio.file.Files.newDirectoryStream(Files.java:471)
	at java.base/java.nio.file.FileTreeWalker.visit(FileTreeWalker.java:300)
	at java.base/java.nio.file.FileTreeWalker.walk(FileTreeWalker.java:322)
	at java.base/java.nio.file.FileTreeIterator.<init>(FileTreeIterator.java:71)
	at java.base/java.nio.file.Files.walk(Files.java:3820)
	at java.base/java.nio.file.Files.walk(Files.java:3874)
	at Application.main(Application.java:15)
```

Running the image locally in Docker causes following output:
```
Verifying certificates...
/etc/ssl/certs/java exists, listing files:
/etc/ssl/certs/java/cacerts
Certificates verified OK!



Getting https://google.com
Got response from https://google.com with status 200 OK
```
