## Problem Statement 

Design a SQL Query Builder that helps construct complex SELECT SQL queries in a clean, readable, and step-by-step manner.
A SQL SELECT query may consist of mandatory parts such as the table name, along with several optional clauses like selected columns, WHERE conditions, JOINs, ORDER BY, and LIMIT. Constructing such queries using string concatenation or large constructors leads to unreadable and error-prone code.
The system should allow clients to build SQL queries fluently while ensuring correctness and flexibility, without exposing the internal construction logic. 
