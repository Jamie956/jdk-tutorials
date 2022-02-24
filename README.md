
# 快速开始
版本：jdk1.8.0_231 



[测试代码](https://github.com/Jamie956/jdk-src/tree/main/jdk-test)

[src.zip解压文件](https://github.com/Jamie956/jdk-src/tree/main/src)



Debug and comments step

1. Import project jdk-test
2. Modify IDEA SDKs settings, Sourcepath set as /path/to/jdk-src/src



# 策略
1. 粗看一下源码，看类的变量、内部类、实现接口、继承类、核心方法
2. 写API 测试方法
3. 调试API 方法，源码写注释



# 正在注释的类
- Socket
- FileChannel
- SocketChannel
- ServerSocket
- ByteBuffer
- Exception
- TimeUnit
- ForkJoinPool //复杂
- PriorityQueue //复杂
- ReentrantReadWriteLock
- LockSupport
- Condition



# 已做注释的类
- ArrayList
- LinkedList
- HashMap
- FileInputStream
- FileOutputStream
- ByteArrayInputStream
- ByteArrayOutputStream
- InputStreamReader
- OutputStreamWriter
- ReentrantLock
- ThreadPoolExecutor
- Semaphore
- CyclicBarrier
- CountDownLatch
- TreeMap
- TreeSet
- Thread
- ConcurrentHashMap
- ArrayDeque
- HashSet
- LinkedHashSet
- FutureTask
- AtomicInteger
- CopyOnWriteArrayList
- CopyOnWriteArraySet
- ArrayBlockingQueue
- LinkedBlockingQueue



# java.util

- Collection
  - ArrayDequeue
  - ArrayList
  - HashSet
  - LinkedHashSet
  - LinkedList
  - PriorityQueue
  - TreeSet
- Map
  - HashMap
  - Treemap

- concurrent
  - Collection
    - ArrayBlokingQueue
    - ConcurrentHashMap
    - CopyOnWriteArrayList
    - CopyOnWriteArraySet
    - LinkedBlockingQueue
  - Lock
    - CountDownLatch
    - LockSupport
    - ReentrantLock
    - ReentrantReadWriteLock
    - Semaphore
  - Atomic
    - AtomicInteger
  - ForkJoinPool
  - FutureTask
  - ThreadPoolExecutor
  - Timeunit



# java.io

- ByteArrayInputStream
- ByteArrayOutputStream
- FileInputStream
- FileOutputStream
- InputStreamReader
- OutputStreamWriter



# java.nio

- ByteBuffer
- CharBuffer
- channels
  - ServerSocketChannel
  - SocketChannel
  - Selector
  - SelectionKey
  - 



# java8



- StreamSupport
- FunctionalInterface
- Optional



# java.net



- HttpURLConnection
- ServerSocket
- Socket







# java.lang

- reflect
  - Method
  - Proxy
  - InvocationHandler

- Thread











