# kotlin-abi-before-after

Run the reproducer: `./gradlew run --rerun-tasks`, you get:

```
ABI fingerprint of com/gradle/abi/InternalInlineFunction.class is: 2084606113631907564
Calling the function yields: foo
```

Edit line 8 in `InternalInlineFunction` (project `target`), replace `println("foo")` with `println("bar")`.

Run the reproducer: `./gradlew run --rerun-tasks`, you get:

```
ABI fingerprint of com/gradle/abi/InternalInlineFunction.class is: -8707675617395730138
Calling the function yields: bar
```

The problem is that the ABI fingerprint for the `InternalInlineFunction` class is different for the two cases.
We believe it should remain the same, because classes using the (non-inline) function `foo()` from it don't need to be recompiled.
