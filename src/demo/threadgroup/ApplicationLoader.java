package demo.threadgroup;

public class ApplicationLoader extends ThreadGroup {
    private ApplicationLoader() {
        super("ApplicationLoader");
    }

    public static void main(String[] args) {
        Runnable appStarter = new Runnable() {
            public void run() {
//invoke your application
//                (MySystem.main(args);
            }
        };
        new Thread(new ApplicationLoader(), appStarter).start();
    }

    //We overload this method from our parent
//ThreadGroup , which will make sure that it
//gets called when it needs to be. This is
//where the magic occurs.
    public void uncaughtException(Thread thread, Throwable exception) {
//Handle the error/exception.
//Typical operations might be displaying a
//useful dialog, writing to an event log, etc.
    }
}