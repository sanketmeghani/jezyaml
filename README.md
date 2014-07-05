jezyaml
=======

Java EasyYaml - **jezyaml** is a light wrapper for reading [YAML][YAML] in Java. It uses [snakeyaml][snakeyaml] to load YAML from a String or a File. **jezyaml** provides easy APIs to get values defined in YAML.

[YAML]: http://en.wikipedia.org/wiki/YAML
[snakeyaml]: http://code.google.com/p/snakeyaml/

Usage
=====

Instantiating `EasyYaml`
------------------------

You can instantiate `EasyYaml` either using a [YAML][YAML] string or a [YAML][YAML] file. To instantiate using a string:

```java
String yamlString = "a: 'string'\nb: 2\nc:\n  - aaa\n  - bbb\nd: false";

EasyYaml easyYaml = EasyYaml.fromString(yamlString);
```

To instantiate using a .yml file:

```java
String yamlFile = "sample.yml";

EasyYaml easyYaml = EasyYaml.fromFile("sample.yml");
```

Accessing Values
----------------

**Sample YAML**
```
receipt:     Oz-Ware Purchase Invoice
date:        2012-08-06
customer:
    given:   Dorothy
    family:  Gale

items:
    - part_no:   A4786
      descrip:   Water Bucket (Filled)
      price:     1.47
      quantity:  4

    - part_no:   E1628
      descrip:   High Heeled "Ruby" Slippers
      size:      8
      price:     100.27
      quantity:  1
```

To retrieve `String` value:
```java
String value = easyYaml.getString("receipt");
```
To retrieve nested values, pass a dotted key:
```java
String customerName = easyYaml.getString("customer.given");
```
To retrieve a `List':
```java
List<Object> values = easyYaml.getList("items");
```
Similar accessor methods avaialble for other data types as well. You can also pass a default value to be returned in case of given key is not found in YAML.

```java
String defaultValue = "Not Available";

//Returns "Not Available"
String contactNo = easyYaml.getString("customer.contactNo", defaultValue);
```