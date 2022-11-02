package youyihj.datatool.data.impl;

import com.blamejared.crafttweaker.impl.data.StringData;
import youyihj.datatool.data.IAdvancedData;

/**
 * @author youyihj
 */
public class AdvancedDataString extends AdvancedDataBase<StringData> {


    public AdvancedDataString(StringData data) {
        super(data);
    }

    @Override
    public String asString() {
        return data.asString();
    }

    @Override
    public IAdvancedData add(IAdvancedData other) {
        return new AdvancedDataString(new StringData(asString() + other.asString()));
    }

    @Override
    public IAdvancedData indexGet(int index) {
        if (index < asString().length()) {
            return new AdvancedDataString(new StringData(asString().substring(index, index + 1)));
        }
        return IAdvancedData.ABSENT;
    }

    @Override
    public int size() {
        return data.asString().length();
    }

    @Override
    public String toString() {
        return asString();
    }
}
