package dev.turtywurty.rendermaster.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

import org.jetbrains.annotations.Nullable;

public class Actions extends ArrayList<Runnable> {
    private static final long serialVersionUID = 4691208644871370970L;
    
    @Override
    @Nullable
    public Runnable remove(int index) {
        return null;
    }
    
    @Override
    public boolean remove(Object o) {
        return contains(o);
    }
    
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public boolean removeIf(Predicate<? super Runnable> filter) {
        return false;
    }
    
    @Nullable
    @Override
    public Runnable set(int index, Runnable element) {
        Objects.checkIndex(index, size());

        if (get(index) != null)
            return null;

        return super.set(index, element);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
    }
}
