package youyihj.datatool.data.impl;

import com.blamejared.crafttweaker.impl.data.ByteArrayData;
import com.blamejared.crafttweaker.impl.data.ByteData;
import org.apache.commons.lang3.ArrayUtils;
import youyihj.datatool.data.IAdvancedData;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author youyihj
 */
public class AdvancedDataByteArray extends AdvancedDataBase<ByteArrayData> {

    public AdvancedDataByteArray(ByteArrayData data) {
        super(data);
    }

    @Override
    public byte[] asByteArray() {
        return data.getInternal().getByteArray();
    }

    @Override
    public int[] asIntArray() {
        byte[] bytes = asByteArray();
        int[] result = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            result[i] = bytes[i];
        }
        return result;
    }

    @Override
    public long[] asLongArray() {
        byte[] bytes = asByteArray();
        long[] result = new long[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            result[i] = bytes[i];
        }
        return result;
    }

    @Override
    public IAdvancedData indexGet(int index) {
        byte[] bytes = asByteArray();
        if (index >= bytes.length) {
            return IAdvancedData.ABSENT;
        } else {
            return new AdvancedDataNumber(new ByteData(bytes[index]));
        }
    }

    @Override
    public void indexSet(int index, IAdvancedData data) {
        byte[] bytes = asByteArray();
        if (index < bytes.length) {
            bytes[index] = data.asByte();
        }
    }

    @Override
    public IAdvancedData add(IAdvancedData other) {
        return new AdvancedDataByteArray(new ByteArrayData(ArrayUtils.add(asByteArray(), other.asByte())));
    }

    @Override
    public String asString() {
        return IntStream.of(asIntArray()).mapToObj(Integer::toString).collect(Collectors.joining(", ", "[", "]"));
    }

    @Override
    public int size() {
        return asByteArray().length;
    }
}
