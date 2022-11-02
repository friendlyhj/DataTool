package youyihj.datatool.data.impl;

import com.blamejared.crafttweaker.impl.data.BoolData;
import youyihj.datatool.data.IAdvancedData;

/**
 * @author youyihj
 */
public class AdvancedDataBool extends AdvancedDataBase<BoolData> {

    public AdvancedDataBool(BoolData data) {
        super(data);
    }

    @Override
    public int asInt() {
        return data.getInternalValue() ? 1 : 0;
    }

    @Override
    public short asShort() {
        return (short) (data.getInternalValue() ? 1 : 0);
    }

    @Override
    public float asFloat() {
        return data.getInternalValue() ? 1 : 0;
    }

    @Override
    public double asDouble() {
        return data.getInternalValue() ? 1 : 0;
    }

    @Override
    public long asLong() {
        return data.getInternalValue() ? 1 : 0;
    }

    @Override
    public byte asByte() {
        return (byte) (data.getInternalValue() ? 1 : 0);
    }

    @Override
    public boolean asBoolean() {
        return data.getInternalValue();
    }

    @Override
    public byte[] asByteArray() {
        return new byte[] {asByte()};
    }

    @Override
    public int[] asIntArray() {
        return new int[] {asInt()};
    }

    @Override
    public long[] asLongArray() {
        return new long[] {asLong()};
    }

    @Override
    public String asString() {
        return String.valueOf(data.getInternalValue());
    }

    @Override
    public IAdvancedData add(IAdvancedData other) {
        return new AdvancedDataBool(new BoolData(asBoolean() && other.asBoolean()));
    }

    @Override
    public IAdvancedData sub(IAdvancedData other) {
        return new AdvancedDataBool(new BoolData(asBoolean() && !other.asBoolean()));
    }

    @Override
    public String toString() {
        return asString();
    }
}
