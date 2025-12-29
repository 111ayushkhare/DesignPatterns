package builder.sqlquerybuilder; 


import builder.sqlquerybuilder.constants.SqlKeywords;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class SqlQuery {
	// Mandatory;
	private final String from;

	// Optional
	private final List<String> columns;
	private final List<String> whereConditions;
	private final List<String> groupBy;
	private final String having;
	private final List<String> orderBy;
	private final Integer limit;
	private final String andWhere;
	private final String orWhere;
	
	private SqlQuery(Builder builder) {
		this.columns = builder.columns;
		this.from = builder.from;
		this.whereConditions = builder.whereConditions;
		this.andWhere = builder.andWhere;
		this.orWhere = builder.orWhere;
		this.groupBy = builder.groupBy;
		this.having = builder.having;
		this.orderBy = builder.orderBy;
		this.limit = builder.limit;
	}

	@Override
	public String toString() {
		StringBuilder query = new StringBuilder("Query: '" + SqlKeywords.SELECT + " ");

		if (!this.columns.isEmpty()) {
			query.append(String.join(", ", this.columns));
		} else {
			query.append("*");
		}

		query.append(" ")
			.append(SqlKeywords.FROM)
			.append(" ")
			.append(this.from);
		
		if (!this.whereConditions.isEmpty()) {
			query.append(" ")
				.append(SqlKeywords.WHERE)
				.append(" ")
				.append(String.join(" " + SqlKeywords.AND + " ", this.whereConditions));
		}
		if (!this.groupBy.isEmpty()) {
			query.append(" ")
				.append(SqlKeywords.GROUP_BY)
				.append(" ")
				.append(String.join(" ", this.groupBy));
		}
		if (this.having != null) {
			query.append(" ")
				.append(SqlKeywords.HAVING)
				.append(" ")
				.append(this.having);
		}
		if (!this.orderBy.isEmpty()) {
			query.append(" ")
				.append(SqlKeywords.ORDER_BY)
				.append(" ")
				.append(String.join(" ", orderBy));
		}
		if (this.limit != null) {
			query.append(" ")
				.append(SqlKeywords.LIMIT)
				.append(" ")
				.append(this.limit);
		}


		return query.append(";'").toString();
	}

	public static class Builder {
		private List<String> columns = new ArrayList<String>();
		private final String from;

		private List<String> whereConditions = new ArrayList<String>();
		private List<String> groupBy = new ArrayList<String>();
		private String having;
		private List<String> orderBy = new ArrayList<String>();
		private Integer limit;
		private String andWhere;
		private String orWhere;

		public Builder(String from) {
			this.from = from;
		}

		public Builder select(String... columns) {
			this.columns.addAll(Arrays.asList(columns));
			return this;
		}
		public Builder where(String ...whereConditions) {
			this.whereConditions.addAll(Arrays.asList(whereConditions));
			return this;
		}
		public Builder andWhere(String andWhere) {
			this.whereConditions.add(andWhere);
			return this;
		}
		public Builder orWhere(String orWhere) {
			this.whereConditions.add(orWhere);
			return this;
		}
		public Builder groupBy(String ...groupBy) {
			this.groupBy.addAll(Arrays.asList(groupBy));
			return this;
		}
		public Builder having(String having) {
			this.having = having;
			return this;
		}
		public Builder orderBy(String ...orderBy) {
			this.orderBy.addAll(Arrays.asList(orderBy));
			return this;
		}
		public Builder limit(int limit) {
			this.limit = limit;
			return this;
		}

		public SqlQuery build() {
			return new SqlQuery(this);
		}
	}
}
