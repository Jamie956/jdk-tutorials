
# 快速开始

下载地址 open jdk：
https://mirrors.tuna.tsinghua.edu.cn/AdoptOpenJDK/8/jdk/x64/windows/

- [测试代码](https://github.com/Jamie956/jdk-src/tree/main/jdk-test)
- [jdk1.8.0_231  src.zip 解压文件](https://github.com/Jamie956/jdk-src/tree/main/jdk8u231-src)
- [jdk8u322-b06-src  src.zip 解压文件](https://github.com/Jamie956/jdk-src/tree/main/jdk8u322-b06-src)



Debug and comments step

1. Import project jdk-test
2. Modify IDEA SDKs settings, Sourcepath set as /path/to/jdk-src/src



# 策略
1. 粗看一下源码，看类的变量、内部类、实现接口、继承类、核心方法
2. 写API 测试方法
3. 调试API 方法，源码写注释



# java.util

- Collection
  - ArrayDequeue 注释
  - ArrayList 注释
  - HashSet 注释
  - LinkedHashSet 注释
  - LinkedList 注释
  - PriorityQueue
  - TreeSet 注释
- Map
  - HashMap 注释
  - Treemap 注释

- concurrent
  - Collection
    - ArrayBlokingQueue 注释
    - ConcurrentHashMap 注释
    - CopyOnWriteArrayList 注释
    - CopyOnWriteArraySet 注释
    - LinkedBlockingQueue 注释
  - Lock
    - CountDownLatch 注释
    - LockSupport
    - ReentrantLock 注释
    - ReentrantReadWriteLock
    - Semaphore 注释
    - CyclicBarrier 注释
  - Atomic
    - AtomicInteger 注释
  - ForkJoinPool
  - FutureTask 注释
  - ThreadPoolExecutor 注释
  - Timeunit
- regex



# java.io

- ByteArrayInputStream 注释
- ByteArrayOutputStream 注释
- FileInputStream 注释
- FileOutputStream 注释
- InputStreamReader 注释
- OutputStreamWriter 注释



# java.nio

- HeapByteBuffer 注释
- channels
  - ServerSocketChannel
  - SocketChannel
  - Selector
  - SelectionKey
  - FileChannel 当前



# java8

- StreamSupport
- FunctionalInterface
- Optional



# java.net/sun.net

- URL 注释
- HttpURLConnection 注释
- ServerSocket 注释
- Socket 未完
- URI



# java.lang

- reflect
  - Method
  - Proxy
  - InvocationHandler
- Thread 注释
- Throwable 注释
  - Exception 注释
    - IOException 注释
    - RuntimeException 注释
      - NullPointerException 注释
  - Error 注释
- String 注释
- Byte
- Short
- Integer 注释
- Long
- Float
- Double
- Char
- Boolean
- StringBuilder 注释
- StringBuffer 注释











































