package logic;

import javax.management.RuntimeErrorException;

public class ClockTimer {
	  
	private long milis;
	private ClockTimerListener clockTimerListener;
    private ClockTimer endTime;
	private String timerName;
	
	private Thread timerThread;
	private volatile boolean isTimerRunning = false;
    private boolean isTimeEnded = false;

	public static final int DIRECTION_FOREWARD = 1;
	public static final int DIRECTION_BACKWARDS = -1;

	private int scale = 1;
	
	public ClockTimer() { 
		this.milis = 0;
	}
	
	public ClockTimer(long milis){
		this.milis = milis;
	}
	
	public ClockTimer(long hours, long minutes, long seconds, long miliseconds){
		setTime(hours, minutes, seconds, miliseconds);
	}
	
	public void setTime(long milis) {
		this.milis = milis;
	}
	
	public void setTime(long hours, long minutes, long seconds, long miliseconds){
		this.milis = (((((hours*60) + minutes)*60) + seconds)*1000) + miliseconds;
	}

	public long getMilis() {
		return milis;
	}
	
	public long getSeconds(){
		return milis/1000;
	}
	
	public long getMinutes(){
		return milis/(1000*60);
	}
	
	public long getHours(){
		return milis/(1000*60*60);
	}
	
	public long getExcessMinutes(){
		return this.getMinutes() - (this.getHours()*60);
	}
	
	public long getExcessSeconds(){
		return this.getSeconds() - (this.getMinutes()*60);
	}
	
	public long getExcessMilis(){
		return this.getMilis() - (this.getSeconds()*1000);
	}
	
	public String getTimeString(){
		return String.format("%02d", getHours()) + ":" + String.format("%02d", getExcessMinutes()) + ":"
				+ String.format("%02d", getExcessSeconds());
	}
	
	public void addTime(ClockTimer timer){
		this.setTime(getMilis() + timer.getMilis());
	}
	
	public void subtractTime(ClockTimer timer){
		this.setTime(getMilis() - timer.getMilis());
	}

    public int getScale() { return scale;}

    public void setScale(int scale) {this.scale = scale;}

    public ClockTimer getEndTime() {
        return endTime;
    }

    public void setEndTime(ClockTimer endTime) {
        this.endTime = endTime;
		isTimeEnded = false;
    }

    public void startTimer(){
        if(endTime == null) {
            setEndTime(new ClockTimer(0));
        }
        if(endTime.getMilis() > this.getMilis()){
            startTimer(DIRECTION_FOREWARD, endTime);
        }else{
            startTimer(DIRECTION_BACKWARDS, endTime);
        }
	}
	
	public void startTimer(final int direction,final ClockTimer endTime){
		if(isTimerRunning) return;
        setEndTime(endTime);
		isTimerRunning = true;
		timerThread = new Thread(){
			@Override
			public void run() {
				super.run();
				try {
					long previousMinutes = getMinutes();
					long previousHours = getHours();
					long previousSeconds = getSeconds();
                    boolean isTimeLimitExceeded;
					if(direction == DIRECTION_FOREWARD){
						isTimeLimitExceeded = getMilis() >= endTime.getMilis();
					}else if(direction == DIRECTION_BACKWARDS){
						isTimeLimitExceeded = getMilis() <= endTime.getMilis();
					}else{
						throw new RuntimeException("Direction undefinied");
					}
					while(!isTimeLimitExceeded && isTimerRunning){
						sleep(100);
						setTime(getMilis() + (scale*direction*100));
						if(clockTimerListener != null) {
                            clockTimerListener.on100MilisUpdate(ClockTimer.this);
                            if (getSeconds() != previousSeconds) {
                                clockTimerListener.onSecondsUpdate(ClockTimer.this);
                            }
                            if (getMinutes() != previousMinutes) {
                                clockTimerListener.onMinutesUpdate(ClockTimer.this);
                            }
                            if (getHours() != previousHours) {
                                clockTimerListener.onHoursUpdate(ClockTimer.this);
                            }
                            previousMinutes = getMinutes();
                            previousHours = getHours();
                            previousSeconds = getSeconds();
                        }
						isTimeLimitExceeded = direction==DIRECTION_FOREWARD ? 
								(getMilis() >= endTime.getMilis()) : (getMilis() <= endTime.getMilis());
					}
					isTimerRunning = false;
					if(isTimeLimitExceeded){
                        isTimeEnded = true;
                        clockTimerListener.onTimerEnd(ClockTimer.this);
                    }
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
		};
		timerThread.start();
	}
	
	public void endTimer() {
        this.milis = endTime.getMilis();
	}

	public void pauseTimer(){
        isTimerRunning = false;
    }

    public boolean isTimerRunning() {
        return isTimerRunning;
    }

    public boolean isTimerEnded(){
        return isTimeEnded;
    }

	public void setClockTimerListener(ClockTimerListener clockTimerListener) {
		this.clockTimerListener = clockTimerListener;
	}

    public String getTimerName() {
        return timerName;
    }

    public void setTimerName(String timerName) {
        this.timerName = timerName;
    }


	public interface ClockTimerListener {
		void onTimerEnd(ClockTimer timer);
		void on100MilisUpdate(ClockTimer timer);
		void onSecondsUpdate(ClockTimer timer);
		void onMinutesUpdate(ClockTimer timer);
		void onHoursUpdate(ClockTimer timer);
	}
}
