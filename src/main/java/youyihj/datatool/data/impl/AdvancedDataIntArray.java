package youyihj.datatool.data.impl;

import com.blamejared.crafttweaker.impl.data.IntArrayData;
import com.blamejared.crafttweaker.impl.data.IntData;
import org.apache.commons.lang3.ArrayUtils;
import youyihj.datatool.data.IAdvancedData;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author youyihj
 */
public class AdvancedDataIntArray extends AdvancedDataBase<IntArrayData> {

    public AdvancedDataIntArray(IntArrayData data) {
        super(data);
    }

    @Override
    public byte[] asByteArray() {
        int[] ints = asIntArray();
        byte[] result = new byte[ints.length];
        for (int i = 0; i < ints.length; i++) {
            result[i] = (byte) ints[i];
        }
        return result;
    }

    @Override
    public int[] asIntArray() {
        return data.getInternal().getIntArray();
    }

    @Override
    public long[] asLongArray() {
        int[] ints = asIntArray();
        long[] result = new long[ints.length];
        for (int i = 0; i < ints.length; i++) {
            result[i] = ints[i];
        }
        return result;
    }

    @Override
    public IAdvancedData indexGet(int index) {
        int[] ints = asIntArray();
        if (index >= ints.length) {
            return IAdvancedData.ABSENT;
        } else {
            return new AdvancedDataNumber(new IntData(ints[index]));
        }
    }

    @Override
    public void indexSet(int index, IAdvancedData data) {
        int[] ints = asIntArray();
        if (index < ints.length) {
            ints[index] = data.asInt();
        }
    }

    @Override
    public IAdvancedData add(IAdvancedData other) {
        return new AdvancedDataIntArray(new IntArrayData(ArrayUtils.add(asIntArray(), other.asInt())));
    }

    @Override
    public List<IAdvancedData> asList() {
        return data.getInternal().stream().map(IntData::new).map(AdvancedDataNumber::new).collect(Collectors.toList());
    }

    @Override
    public String asString() {
        return IntStream.of(asIntArray()).mapToObj(Integer::toString).collect(Collectors.joining(", ", "[", "]"));
    }

    @Override
    public int size() {
        return asIntArray().length;
    }
}
