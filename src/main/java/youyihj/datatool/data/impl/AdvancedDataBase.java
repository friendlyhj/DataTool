package youyihj.datatool.data.impl;

import com.blamejared.crafttweaker.api.data.IData;
import com.google.common.base.Objects;
import youyihj.datatool.data.IAdvancedData;

/**
 * @author youyihj
 */
public abstract class AdvancedDataBase<T extends IData> implements IAdvancedData {
    protected T data;

    public AdvancedDataBase(T data) {
        this.data = data;
    }

    @Override
    public IData asIData() {
        return data;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + ": " + asString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(asIData());
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass() && asIData().equals(((AdvancedDataBase<?>) obj).asIData());
    }
}
