SELECT product_name
FROM public.ORDERS
         inner JOIN public.CUSTOMERS
                    ON CUSTOMERS.id = orders.customer_id
WHERE lower(customers.name) = LOWER(:name);

