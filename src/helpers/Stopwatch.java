package helpers;

public class Stopwatch {
    private long startTime = 0;
    private long stopTime = 0;
    private boolean isRunning = false;

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.isRunning = true;
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.isRunning = false;
    }

    // elapsed time in milliseconds
    public long getElapsedTime() {
        long elapsed;
        if (isRunning) {
            elapsed = (System.currentTimeMillis() - startTime);
        } else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }

    public void reset() {
        this.stop();
        this.startTime = 0;
        this.stopTime = 0;
        this.isRunning = false;
    }
}
