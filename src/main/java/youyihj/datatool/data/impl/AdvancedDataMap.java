package youyihj.datatool.data.impl;

import com.blamejared.crafttweaker.impl.data.MapData;
import org.apache.commons.lang3.tuple.Pair;
import youyihj.datatool.data.IAdvancedData;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author youyihj
 */
public class AdvancedDataMap extends AdvancedDataBase<MapData> {

    public AdvancedDataMap(MapData data) {
        super(data);
    }

    @Override
    public String asString() {
        return this.data.asString();
    }

    @Override
    public IAdvancedData add(IAdvancedData other) {
        if (other instanceof AdvancedDataMap) {
            return new AdvancedDataMap(data.merge(((AdvancedDataMap) other).data));
        }
        return IAdvancedData.ABSENT;
    }

    @Override
    public IAdvancedData sub(IAdvancedData other) {
        if (other instanceof AdvancedDataMap) {
            MapData copy = ((MapData) this.data.copy());
            for (String key : ((AdvancedDataMap) other).data.getKeySet()) {
                copy.remove(key);
            }
            return new AdvancedDataMap(copy);
        }
        return IAdvancedData.ABSENT;
    }

    @Override
    public IAdvancedData memberGet(String key) {
        return IAdvancedData.of(this.data.getAt(key));
    }

    @Override
    public void memberSet(String key, IAdvancedData data) {
        this.data.put(key, data.asIData());
    }

    @Override
    public Map<String, IAdvancedData> asMap() {
        return data.asMap().entrySet().stream()
                .map(entry -> Pair.of(entry.getKey(), IAdvancedData.of(entry.getValue())))
                .collect(Collectors.toMap(Pair::getLeft, Pair::getRight));
    }

    @Override
    public int size() {
        return this.data.getSize();
    }
}
