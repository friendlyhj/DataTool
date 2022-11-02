package youyihj.datatool.data.impl;

import com.blamejared.crafttweaker.api.data.IData;
import com.blamejared.crafttweaker.api.data.INumberData;
import com.blamejared.crafttweaker.impl.data.*;
import youyihj.datatool.data.IAdvancedData;

/**
 * @author youyihj
 */
public class AdvancedDataNumber extends AdvancedDataBase<INumberData> {

    public AdvancedDataNumber(INumberData data) {
        super(data);
    }

    @Override
    public int asInt() {
        return data.getInt();
    }

    @Override
    public short asShort() {
        return data.getShort();
    }

    @Override
    public float asFloat() {
        return data.getFloat();
    }

    @Override
    public double asDouble() {
        return data.getDouble();
    }

    @Override
    public long asLong() {
        return data.getLong();
    }

    @Override
    public byte asByte() {
        return data.getByte();
    }

    @Override
    public boolean asBoolean() {
        return data.getByte() == 1;
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
        return String.valueOf(data.getInternal().getAsNumber());
    }

    @Override
    public IAdvancedData add(IAdvancedData other) {
        Class<? extends IData> dataClass = this.asIData().getClass();
        if (dataClass == other.asIData().getClass()) {
            if (dataClass == IntData.class) {
                return new AdvancedDataNumber(new IntData(asInt() + other.asInt()));
            }
            if (dataClass == LongData.class) {
                return new AdvancedDataNumber(new LongData(asLong() + other.asLong()));
            }
            if (dataClass == ShortData.class) {
                return new AdvancedDataNumber(new ShortData((short) (asShort() + other.asShort())));
            }
            if (dataClass == FloatData.class) {
                return new AdvancedDataNumber(new FloatData( asFloat() + other.asFloat()));
            }
            if (dataClass == ByteData.class) {
                return new AdvancedDataNumber(new ByteData((byte) (asByte() + other.asByte())));
            }
        }
        return new AdvancedDataNumber(new DoubleData(asDouble() + other.asDouble()));
    }

    @Override
    public IAdvancedData sub(IAdvancedData other) {
        Class<? extends IData> dataClass = this.asIData().getClass();
        if (dataClass == other.asIData().getClass()) {
            if (dataClass == IntData.class) {
                return new AdvancedDataNumber(new IntData(asInt() - other.asInt()));
            }
            if (dataClass == LongData.class) {
                return new AdvancedDataNumber(new LongData(asLong() - other.asLong()));
            }
            if (dataClass == ShortData.class) {
                return new AdvancedDataNumber(new ShortData((short) (asShort() - other.asShort())));
            }
            if (dataClass == FloatData.class) {
                return new AdvancedDataNumber(new FloatData( asFloat() - other.asFloat()));
            }
            if (dataClass == ByteData.class) {
                return new AdvancedDataNumber(new ByteData((byte) (asByte() - other.asByte())));
            }
        }
        return new AdvancedDataNumber(new DoubleData(asDouble() - other.asDouble()));
    }

    @Override
    public String toString() {
        return asString();
    }
}
