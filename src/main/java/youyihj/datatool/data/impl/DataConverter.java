package youyihj.datatool.data.impl;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.data.IData;
import com.blamejared.crafttweaker.api.data.INumberData;
import com.blamejared.crafttweaker.impl.data.*;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.datatool.data.IAdvancedData;

/**
 * @docParam this (1 as IData)
 * @author youyihj
 */
@ZenRegister
@ZenCodeType.Expansion("crafttweaker.api.data.IData")
@Document("mods/DataTool/IDataExpansion")
public class DataConverter {
    /**
     * Coverts IData to IAdvancedData.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster(implicit = true)
    public static IAdvancedData advance(IData data) {
        if (data == null) return IAdvancedData.ABSENT;
        if (data instanceof INumberData) {
            return new AdvancedDataNumber(data.asNumber());
        }
        if (data instanceof BoolData) {
            return new AdvancedDataBool(((BoolData) data));
        }
        if (data instanceof StringData) {
            return new AdvancedDataString(((StringData) data));
        }
        if (data instanceof MapData) {
            return new AdvancedDataMap((MapData) data);
        }
        if (data instanceof ListData) {
            return new AdvancedDataList((ListData) data);
        }
        if (data instanceof ByteArrayData) {
            return new AdvancedDataByteArray((ByteArrayData) data);
        }
        if (data instanceof IntArrayData) {
            return new AdvancedDataIntArray((IntArrayData) data);
        }
        if (data instanceof LongArrayData) {
            return new AdvancedDataLongArray((LongArrayData) data);
        }
        CraftTweakerAPI.logError("Unknown data: " + data);
        return IAdvancedData.ABSENT;
    }
}
