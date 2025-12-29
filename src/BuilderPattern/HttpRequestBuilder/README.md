## Problem Statement 

Design an HTTP Request Builder that allows clients to construct an HTTP request in a step-by-step and readable manner.
An HTTP request typically consists of mandatory attributes such as the request URL and HTTP method, along with several optional attributes like headers, query parameters, request body, timeout, and authentication tokens. Creating such an object using constructors leads to poor readability and a large number of overloaded constructors.
The system should provide a flexible way to build HTTP request objects while ensuring that required fields are validated and the final object remains immutable once created.

