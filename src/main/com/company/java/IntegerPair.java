package main.com.company.java;

public class IntegerPair
{
    public int first;
    public int second;

    public IntegerPair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o.getClass() != IntegerPair.class) return false;
        var anotherPair = (IntegerPair)o;
        return this.first == anotherPair.first && this.second == anotherPair.second;
    }

    @Override
    public int hashCode()
    {
        return first * 100 + second;
    }
}

