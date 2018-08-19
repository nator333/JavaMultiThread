# Purpose
- check thread function
- run Gradle tasks

# Expected output

```
$ gradle run

3:08:25 PM: Executing task 'run'...

> Task :compileJava
> Task :processResources NO-SOURCE
> Task :classes

> Task :run
Start practice program...
Main Started --- Thread Id : 1
condition = 6.332853285741714
onSuccess!
hogehoge[0]
hogehoge[1]
hogehoge[2]
hogehoge[3]
hogehoge[4]
hogehoge[5]
hogehoge[6]
hogehoge[7]
hogehoge[8]
hogehoge[9]
runnable2 Started --- Thread Id : 11
runnable1 Started --- Thread Id : 10
Result1 :false
Result2 :false
Waiting Until Multi Thread finished
runnable1 Started --- Thread Id : 12
runnable2 Started --- Thread Id : 13
--------
instanceName: runnable1
hoge: 1
--------
--------
instanceName: runnable2
hoge: 2
--------
--------
instanceName: runnable1
hoge: 3
--------
--------
instanceName: runnable2
hoge: 4
--------
--------
instanceName: runnable1
hoge: 5
--------
--------
instanceName: runnable2
hoge: 6
--------
--------
instanceName: runnable1
hoge: 7
--------
--------
instanceName: runnable2
hoge: 8
--------
--------
instanceName: runnable1
hoge: 9
--------
--------
instanceName: runnable2
hoge: 10
--------
--------
instanceName: runnable1
hoge: 11
--------
--------
instanceName: runnable2
hoge: 12
--------
--------
instanceName: runnable1
hoge: 13
--------
--------
instanceName: runnable2
hoge: 14
--------
--------
instanceName: runnable1
hoge: 15
--------
--------
instanceName: runnable2
hoge: 16
--------
--------
instanceName: runnable1
hoge: 17
--------
--------
instanceName: runnable2
hoge: 18
--------
--------
instanceName: runnable1
hoge: 19
--------
--------
instanceName: runnable2
hoge: 20
--------
Main finished --- Thread Id : 1

BUILD SUCCESSFUL in 1s
2 actionable tasks: 2 executed
3:08:27 PM: Task execution finished 'run'.

```

```
$ gradle test

BUILD SUCCESSFUL in 1s
3 actionable tasks: 2 executed, 1 up-to-date

```
