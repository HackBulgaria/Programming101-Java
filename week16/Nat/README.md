# Nat

We are going to implement natural numbers without integers. This is called [Peano Arithmetic](https://en.wikipedia.org/wiki/Peano_axioms#Arithmetic)

We are going to represent `0` with `Zero` and every number will be a successor of the previous.

Few examples:

```
1 = Succ(Zero) - One is the successor of zero
2 = Succ(Succ(Zero)) - Two is hte successor of the successor of zero.
```

## Abstract Nat class

We are going to have the following abstract base class:

```java
public abstract class Nat {
	public abstract boolean isZero();
	public abstract Nat next();
	public abstract Nat prev();
	public abstract Nat add(Nat b);
	public abstract Nat minus(Nat b);
	public abstract Integer toInt();
}
```

## Zero and Succ

Our task will be to implement the following subtypes of `Nat`: `class Zero extends Nat {}` and `class Succ extends Nat{}`
