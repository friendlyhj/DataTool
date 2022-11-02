package youyihj.datatool.data.impl;

import com.blamejared.crafttweaker.impl.data.LongArrayData;
import org.apache.commons.lang3.ArrayUtils;
import youyihj.datatool.data.IAdvancedData;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author youyihj
 */
public class AdvancedDataLongArray extends AdvancedDataBase<LongArrayData> {

    public AdvancedDataLongArray(LongArrayData data) {
        super(data);
    }

    @Override
    public byte[] asByteArray() {
        long[] longs = asLongArray();
        byte[] result = new byte[longs.length];
        for (int i = 0; i < longs.length; i++) {
            result[i] = (byte) longs[i];
        }
        return result;
    }

    @Override
    public int[] asIntArray() {
        long[] longs = asLongArray();
        int[] result = new int[longs.length];
        for (int i = 0; i < longs.length; i++) {
            result[i] = (int) longs[i];
        }
        return result;
    }

    @Override
    public long[] asLongArray() {
        return data.getInternal().getAsLongArray();
    }

    @Override
    public String asString() {
        return LongStream.of(asLongArray()).mapToObj(Long::toString).collect(Collectors.joining(", ", "[", "]"));
    }

    @Override
    public IAdvancedData add(IAdvancedData other) {
        return new AdvancedDataLongArray(new LongArrayData(ArrayUtils.add(asLongArray(), other.asLong())));
    }

    @Override
    public int size() {
        return asLongArray().length;
    }
}
