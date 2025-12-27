## Problem Statement

An e-commerce system needs to support multiple payment methods such as
Credit Card, UPI, Net Banking, etc. Each payment method has its own
processing logic, but the client code should not be tightly coupled to
any specific payment implementation.

### Example Flow

```text
Input  : amount = 1500, paymentType = UPI
Output : Payment of ₹1500 processed via UPI
```
