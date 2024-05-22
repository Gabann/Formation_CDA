package jpa.tp_computer.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Entity
@Embeddable
public class Address
{
	String address;
	@Column(name = "address_type")
	String addressType;

	public Address()
	{
	}

	private Address(Builder builder)
	{
		address = builder.address;
		addressType = builder.addressType;
	}


	public static final class Builder
	{
		private String address;
		private String addressType;

		public Builder()
		{
		}

		public Builder address(String val)
		{
			address = val;
			return this;
		}

		public Builder addressType(String val)
		{
			addressType = val;
			return this;
		}

		public Address build()
		{
			return new Address(this);
		}
	}
}
