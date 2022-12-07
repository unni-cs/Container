package com.agile.customerservice.services;

import com.agile.customerservice.common.Brand;
import com.agile.customerservice.models.Credit;

public interface ICreditService {

	Iterable<Credit> credits();

	Credit getCredit(Brand brand);

}