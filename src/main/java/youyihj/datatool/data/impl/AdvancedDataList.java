package youyihj.datatool.data.impl;

import com.blamejared.crafttweaker.api.data.IData;
import com.blamejared.crafttweaker.api.data.NBTConverter;
import com.blamejared.crafttweaker.impl.data.ListData;
import net.minecraft.nbt.ListNBT;
import youyihj.datatool.data.IAdvancedData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author youyihj
 */
public class AdvancedDataList extends AdvancedDataBase<ListData> {

    public AdvancedDataList(ListData data) {
        super(data);
    }

    @Override
    public byte[] asByteArray() {
        List<IData> dataList = data.asList();
        byte[] bytes = new byte[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            bytes[i] = IAdvancedData.of(dataList.get(i)).asByte();
        }
        return bytes;
    }

    @Override
    public int[] asIntArray() {
        return data.asList().stream()
                .map(IAdvancedData::of)
                .mapToInt(IAdvancedData::asInt)
                .toArray();
    }

    @Override
    public long[] asLongArray() {
        return data.asList().stream()
                .map(IAdvancedData::of)
                .mapToLong(IAdvancedData::asLong)
                .toArray();
    }

    @Override
    public String asString() {
        return data.asList().stream()
                .map(IAdvancedData::of)
                .map(IAdvancedData::asString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    @Override
    public void remove(int index) {
        this.data.remove(index);
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @Override
    public IAdvancedData add(IAdvancedData other) {
        if (other instanceof AdvancedDataList) {
            ListData copy = (ListData) this.data.copy();
            for (IData otherData : ((AdvancedDataList) other).data.asList()) {
                copy.add(otherData);
            }
            return new AdvancedDataList(copy);
        }
        return IAdvancedData.ABSENT;
    }

    @Override
    public IAdvancedData sub(IAdvancedData other) {
        if (other instanceof AdvancedDataList) {
            ListData copy = (ListData) this.data.copy();
            ListNBT internal = copy.getInternal();
            for (IData otherData : ((AdvancedDataList) other).data.asList()) {
                internal.remove(otherData.getInternal());
            }
            return new AdvancedDataList(copy);
        }
        return IAdvancedData.ABSENT;
    }

    @Override
    public IAdvancedData indexGet(int index) {
        ListNBT internal = this.data.getInternal();
        if (index < internal.size()) {
            return IAdvancedData.of(NBTConverter.convert(internal.get(index)));
        }
        return IAdvancedData.ABSENT;
    }

    @Override
    public void indexSet(int index, IAdvancedData data) {
        this.data.setAt(index, data.asIData());
    }

    @Override
    public List<IAdvancedData> asList() {
        return data.asList().stream().map(IAdvancedData::of).collect(Collectors.toList());
    }

    @Override
    public int size() {
        return data.size();
    }
}
