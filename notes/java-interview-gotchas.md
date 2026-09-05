# Java interview gotchas

Language / syntax constraints that trip you up under pressure. Append entries as you hit them while solving.

---

## Primitives vs wrappers — no `new` on `double` / `int` / …

### Why

Java has two layers:

| | Primitives | Wrappers (objects) |
|--|------------|---------------------|
| Types | `int`, `long`, `double`, `boolean`, … | `Integer`, `Long`, `Double`, `Boolean`, … |
| Storage | Raw value on stack / in array | Heap object holding a value |
| Create with | Literal / expression: `double x = 0;` | `new Double(0)` (deprecated) or `Double.valueOf(0)` |
| `new`? | **No** — not a class | Yes — they are classes |

`new` only constructs **objects**. Primitives are not classes, so `new double(0)` does not compile.

### How to approach (in an interview)

1. Need a number to track (sum, max, avg)? Prefer the **primitive** (`int`, `double`) unless the API forces an object.
2. Need “missing” / nullability / generics (`List<Double>`, `Map` keys)? Use the **wrapper**.
3. Returning `double` from a method: return a primitive expression — `return maxSum / k;` — not `new Double(...)`.

### Variations you’ll see

```java
// OK — primitive
double maxSum = 0;
maxSum = sum;                    // after first window
return maxSum / k;

// OK — autoboxing (compiler wraps for you)
Double boxed = maxSum;           // primitive → Double
double back = boxed;             // unboxing

// OK — explicit (rarely needed in LC)
return Double.valueOf(maxSum / k);  // works, but redundant if return type is double
// (method return type double will unbox anyway if you pass a Double)

// FAIL — does not compile
// double x = new double(0);
// Double y = new double(0);     // still wrong: new needs a type name that is a class
```

**Arrays:** `double[]` holds primitives. `Double[]` holds object references (can be `null` elements).

**Comparison pitfall:** `==` on wrappers compares **references** (except some cached `Integer`s). Prefer `a.equals(b)` or unbox first: `a.doubleValue() == b`.

**Null:** only wrappers can be `null`. Unboxing a null `Double` → `NullPointerException`.

### Quick recall

> Need a number → start with `int`/`double`.  
> `new` → only for objects (`new ArrayList<>()`, not `new int`).  
> Average problems → keep **sum as `double` or `long`**, divide once at the end.
