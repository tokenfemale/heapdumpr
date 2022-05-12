## Heapdumpr

Cause an OOM and heap dump by visiting an endpoint

Why? This allows you to easily write a script that is executed when an OOM occurs. This is only useful for local development.

*How to launch*

From the root directory run `./gradlew bootRun`
Visit http://localhost:8080/heap-dump
This will only execute the script once even though it will generate many OOMs, not sure why.

*How to modify configuration*

The command line configuration can be found [here](https://github.com/tokenfemale/heapdumpr/blob/e97e306aa951238a4be67177c47562a92ae71dd7/build.gradle#L26)

