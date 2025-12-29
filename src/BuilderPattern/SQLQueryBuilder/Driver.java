package builder.sqlquerybuilder;


public class Driver {
	public static void main(String[] args) {
		SqlQuery query1 = new SqlQuery.Builder("students")
			.where("age>90")
			.limit(5)
			.build();

		SqlQuery query2 = new SqlQuery.Builder("teachers")
			.where("salary>2000000")
			.groupBy("department")
			.orderBy("name")
			.limit(10)
			.build();

		SqlQuery query3 = new SqlQuery.Builder("schools")
			.select("id", "name", "est")
			.where("(strength > 20000 AND avg_fees < 300000)")
			.orWhere("total_rooms > 50")
			.andWhere("(total_peons < 10 AND total_mds > 4)")
			.groupBy("department")
			.orderBy("name")
			.limit(10)
			.build();

		System.out.println(query1);
		System.out.println(query2);
		System.out.println(query3);
	}
}
