package sec04_synchronizedmethodandblock.EX06;

public enum SynchronizedKey {

    A_KEY, B_KEY;

    public Object getLock() {
        return this;
    }

}
