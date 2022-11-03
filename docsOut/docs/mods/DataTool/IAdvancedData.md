# IAdvancedData

An IAdvancedData is a wrapper of IData. It provides an easier way to handle data.

This class was added by a mod with mod-id `crafttweakerdatatool`. So you need to have this mod installed if you want to use this feature.

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.datatool.IAdvancedData;
```


## Static Methods

:::group{name=of}

Return Type: [IAdvancedData](/mods/DataTool/IAdvancedData)

```zenscript
IAdvancedData.of(data as IData?) as IAdvancedData
```

| Parameter | Type | Description |
|-----------|------|-------------|
| data | [IData](/vanilla/api/data/IData)? | No Description Provided |


:::

## Static Properties

| Name | Type | Has Getter | Has Setter | Description |
|------|------|------------|------------|-------------|
| ABSENT | [IAdvancedData](/mods/DataTool/IAdvancedData) | true | false | An IAdvancedData with no IData reference. Replaces null value to avoid annoying null check. <br />  <br />  asNumber/asBoolean/asString methods return 0/false/empty string. <br />  <br />  indexGet and memberGet method return absent data itself. |

## Casters

| Result type | Is Implicit |
|-------------|-------------|
| boolean | false |
| byte | false |
| byte[] | false |
| double | false |
| float | false |
| [IAdvancedData](/mods/DataTool/IAdvancedData)[string] | false |
| int | false |
| int[] | false |
| long | false |
| long[] | false |
| short | false |
| stdlib.List&lt;[IAdvancedData](/mods/DataTool/IAdvancedData)&gt; | false |
| string | false |

## Methods

:::group{name=add}

Returns a new data as the combination of the two data. The operation doesn't mutate the origin data.

Return Type: [IAdvancedData](/mods/DataTool/IAdvancedData)

```zenscript
IAdvancedData.add(other as IAdvancedData) as IAdvancedData
```

| Parameter | Type | Description |
|-----------|------|-------------|
| other | [IAdvancedData](/mods/DataTool/IAdvancedData) | No Description Provided |


:::

:::group{name=asBoolean}

Gets the value of this data to boolean. Returns false if it is not a number.

Return Type: boolean

```zenscript
// IAdvancedData.asBoolean() as boolean

(1 as IData).advance().asBoolean();
```

:::

:::group{name=asByte}

Gets the value of this data to byte. Returns 0 if it is not a number.

Return Type: byte

```zenscript
// IAdvancedData.asByte() as byte

(1 as IData).advance().asByte();
```

:::

:::group{name=asByteArray}

Gets the value of this data to byte array. Returns an empty array if it is not an array.

Return Type: byte[]

```zenscript
// IAdvancedData.asByteArray() as byte[]

(1 as IData).advance().asByteArray();
```

:::

:::group{name=asDouble}

Gets the value of this data to double. Returns 0 if it is not a number.

Return Type: double

```zenscript
// IAdvancedData.asDouble() as double

(1 as IData).advance().asDouble();
```

:::

:::group{name=asFloat}

Gets the value of this data to float. Returns 0 if it is not a number.

Return Type: float

```zenscript
// IAdvancedData.asFloat() as float

(1 as IData).advance().asFloat();
```

:::

:::group{name=asInt}

Gets the value of this data to int. Returns 0 if it is not a number.

Return Type: int

```zenscript
// IAdvancedData.asInt() as int

(1 as IData).advance().asInt();
```

:::

:::group{name=asIntArray}

Gets the value of this data to int array. Returns an empty array if it is not an array.

Return Type: int[]

```zenscript
// IAdvancedData.asIntArray() as int[]

(1 as IData).advance().asIntArray();
```

:::

:::group{name=asList}

Gets a List representation of this IData. Returns an empty list if it is not a list or an array.

Return Type: stdlib.List&lt;[IAdvancedData](/mods/DataTool/IAdvancedData)&gt;

```zenscript
// IAdvancedData.asList() as stdlib.List<IAdvancedData>

(1 as IData).advance().asList();
```

:::

:::group{name=asLong}

Gets the value of this data to long. Returns 0 if it is not a number.

Return Type: long

```zenscript
// IAdvancedData.asLong() as long

(1 as IData).advance().asLong();
```

:::

:::group{name=asLongArray}

Gets the value of this data to long array. Returns an empty array if it is not an array.

Return Type: long[]

```zenscript
// IAdvancedData.asLongArray() as long[]

(1 as IData).advance().asLongArray();
```

:::

:::group{name=asMap}

Gets a Map representation of this IData. Returns an empty map if it is not a DataMap.

Return Type: [IAdvancedData](/mods/DataTool/IAdvancedData)[string]

```zenscript
// IAdvancedData.asMap() as IAdvancedData[string]

(1 as IData).advance().asMap();
```

:::

:::group{name=asShort}

Gets the value of this data to short. Returns 0 if it is not a number.

Return Type: short

```zenscript
// IAdvancedData.asShort() as short

(1 as IData).advance().asShort();
```

:::

:::group{name=asString}

Gets a string representation of this data

Return Type: string

```zenscript
// IAdvancedData.asString() as string

(1 as IData).advance().asString();
```

:::

:::group{name=cast}

Converts to CraftTweaker IData. Throws an exception if the advanced data is not an instance of the expected class.

Returns: the IData  
Return Type: T

```zenscript
IAdvancedData.cast<T : IData>() as T
```

| Parameter | Type | Description |
|-----------|------|-------------|
| T | [IData](/vanilla/api/data/IData) | No Description Provided |


:::

:::group{name=clear}

Removes all elements of this data. Only works for DataList.

Return Type: void

```zenscript
// IAdvancedData.clear() as void

(1 as IData).advance().clear();
```

:::

:::group{name=contains}

Checks if this IData contains another IData

Return Type: boolean

```zenscript
IAdvancedData.contains(other as IAdvancedData) as boolean
```

| Parameter | Type | Description |
|-----------|------|-------------|
| other | [IAdvancedData](/mods/DataTool/IAdvancedData) | No Description Provided |


:::

:::group{name=indexGet}

Gets the data on the given index. Returns absent data if it is not a list or an array.

Return Type: [IAdvancedData](/mods/DataTool/IAdvancedData)

```zenscript
IAdvancedData.indexGet(index as int) as IAdvancedData
```

| Parameter | Type | Description |
|-----------|------|-------------|
| index | int | No Description Provided |


:::

:::group{name=indexSet}

Sets the data on the given index. Returns absent data if it is not a list or an array.

Return Type: void

```zenscript
IAdvancedData.indexSet(index as int, data as IAdvancedData) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| index | int | No Description Provided |
| data | [IAdvancedData](/mods/DataTool/IAdvancedData) | No Description Provided |


:::

:::group{name=memberGet}

Gets the value associated with the key. Only works for DataMap

Return Type: [IAdvancedData](/mods/DataTool/IAdvancedData)

```zenscript
IAdvancedData.memberGet(key as string) as IAdvancedData
```

| Parameter | Type | Description |
|-----------|------|-------------|
| key | string | No Description Provided |


:::

:::group{name=memberSet}

Sets the value associated with the key. Only works for DataMap

Return Type: void

```zenscript
IAdvancedData.memberSet(key as string, data as IAdvancedData) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| key | string | No Description Provided |
| data | [IAdvancedData](/mods/DataTool/IAdvancedData) | No Description Provided |


:::

:::group{name=orElse}

Returns the contained instance if it is present; defaultValue otherwise

Return Type: [IAdvancedData](/mods/DataTool/IAdvancedData)

```zenscript
IAdvancedData.orElse(defaultValue as IAdvancedData) as IAdvancedData
```

| Parameter | Type | Description |
|-----------|------|-------------|
| defaultValue | [IAdvancedData](/mods/DataTool/IAdvancedData) | No Description Provided |


:::

:::group{name=remove}

Removes the element of this data at the given index. Only works for DataList.

Return Type: void

```zenscript
IAdvancedData.remove(index as int) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| index | int | No Description Provided |


:::

:::group{name=sub}

Returns a new data as the subtraction of the two data. Returns absent data if the operation is not supported.
 The operation doesn't mutate the origin data.

Return Type: [IAdvancedData](/mods/DataTool/IAdvancedData)

```zenscript
IAdvancedData.sub(other as IAdvancedData) as IAdvancedData
```

| Parameter | Type | Description |
|-----------|------|-------------|
| other | [IAdvancedData](/mods/DataTool/IAdvancedData) | No Description Provided |


:::


## Operators

:::group{name=ADD}

Returns a new data as the combination of the two data. The operation doesn't mutate the origin data.

```zenscript
myIAdvancedData + other as IAdvancedData
```

:::

:::group{name=CONTAINS}

Checks if this IData contains another IData

```zenscript
other as IAdvancedData in myIAdvancedData
```

:::

:::group{name=MEMBERGETTER}

Gets the value associated with the key. Only works for DataMap

```zenscript
myIAdvancedData.key as string
```

:::

:::group{name=MEMBERSETTER}

Sets the value associated with the key. Only works for DataMap

```zenscript
myIAdvancedData.key as string = data as IAdvancedData
```

:::

:::group{name=SUB}

Returns a new data as the subtraction of the two data. Returns absent data if the operation is not supported. <br />  The operation doesn't mutate the origin data.

```zenscript
myIAdvancedData - other as IAdvancedData
```

:::


## Properties

| Name | Type | Has Getter | Has Setter | Description |
|------|------|------------|------------|-------------|
|  | boolean | true | false | If the data doesn't handle a value |

