class Foo {
    
    int count ;

    public Foo() {
        count = 1;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while(count!=1)
            wait();
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.count++;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        
        while(count!=2)
            wait();
        
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        this.count++;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(count!=3)
            wait();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        notifyAll();
    }
}