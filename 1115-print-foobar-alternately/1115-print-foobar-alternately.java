class FooBar {
    private int n;
    
    Integer count;

    public FooBar(int n) {
        this.n = n;
        this.count = 1;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
         //   synchronized(count){
                while(count%2==0)
                    wait();
                    
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
                this.count++;
                notify();
         //   }
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            //lock kisi object pr hi le skte hai, not on primitive
           // synchronized(count){
                while(count%2==1)
                    wait();
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
                this.count++;
                notify();
           // }  
        }
    }
}