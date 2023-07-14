--insert attribute

insert into attribute
values ('eeafaec8-bd4e-4023-8dc6-f9d2d1f333e2', 'Цвет');

insert into attribute_value (attribute_value_id, attribute_id, value)
values ('e2cb2ba4-aaf1-11ed-afa1-0242ac120002', 'eeafaec8-bd4e-4023-8dc6-f9d2d1f333e2', 'Красный');
insert into attribute_value (attribute_value_id, attribute_id, value)
values ('ef3a280e-aaf1-11ed-afa1-0242ac120002', 'eeafaec8-bd4e-4023-8dc6-f9d2d1f333e2', 'Чёрный');
insert into attribute_value (attribute_value_id, attribute_id, value)
values ('21d04825-9845-4499-ac14-e8a33540f91d', 'eeafaec8-bd4e-4023-8dc6-f9d2d1f333e2', 'Синий');

insert into attribute
values ('6bb48f58-d2b3-4c59-999a-fa78e266a669', 'Размер');

insert into attribute_value (attribute_value_id, attribute_id, value)
values ('3657521c-dd73-4c26-a8f0-1dd570bc1907', '6bb48f58-d2b3-4c59-999a-fa78e266a669', 'Большой');
insert into attribute_value (attribute_value_id, attribute_id, value)
values ('270d0e8b-7da7-4d32-bf75-948cfc0c1b51', '6bb48f58-d2b3-4c59-999a-fa78e266a669', 'Средний');
insert into attribute_value (attribute_value_id, attribute_id, value)
values ('ae099b84-46ac-428f-8b22-7c26f05ef77e', '6bb48f58-d2b3-4c59-999a-fa78e266a669', 'Маленький');

--insert filter
insert into public.filter
values ('60201e0c-c8b8-45e0-832e-453094cb1fdc', true, 'empty', 'eeafaec8-bd4e-4023-8dc6-f9d2d1f333e2');
insert into public.filter
values ('95dc922c-6430-4a2d-8f7d-391e536353a7', true, 'empty', '6bb48f58-d2b3-4c59-999a-fa78e266a669');


--insert categorires
INSERT INTO public.category
VALUES ('d93ce117-7073-4f44-b396-858bdd8b7056', null, 'STUB', 'Оружие');
INSERT INTO public.category
VALUES ('cebf75be-dfe7-4f2e-a60f-539387032a00', 'd93ce117-7073-4f44-b396-858bdd8b7056', ' STUB ', 'Патроны');
INSERT INTO public.category
VALUES ('4a333f98-507b-4c0f-b0e7-2385dce93b5d', null, 'STUB', 'Рыбалка');
INSERT INTO public.category
VALUES ('4fd35dda-deca-4745-9b5a-bf0f43ebd8ad', null, 'STUB', 'Без категории');

--insert manufactures
insert into public.manufacturer
values ('9260be8b-11bd-4799-b19a-8f9b7283e439', 'Челябинск');
insert into public.manufacturer
values ('ab19b473-e1fd-48cd-9fcb-e47e89a1e989', 'ИЖ-МАШ');

--insert filter_j_category
INSERT INTO public.filter_j_category
(category_id, filter_id)
VALUES ('d93ce117-7073-4f44-b396-858bdd8b7056', '60201e0c-c8b8-45e0-832e-453094cb1fdc');
INSERT INTO public.filter_j_category
(category_id, filter_id)
VALUES ('d93ce117-7073-4f44-b396-858bdd8b7056', '95dc922c-6430-4a2d-8f7d-391e536353a7');

--insert product
insert into product (product_id, category_id, manufacturer_id, title, article, price, quantity, is_active, description)
values ('2d752d40-aaf1-11ed-afa1-0242ac120002', 'd93ce117-7073-4f44-b396-858bdd8b7056', '9260be8b-11bd-4799-b19a-8f9b7283e439', 'Ствол 1', '123', 123, 2, true, 'test 1');
insert into product (product_id, category_id, manufacturer_id, title, article, price, quantity, is_active, description)
values ('d39d3c95-eac1-44aa-8d30-b124d2acc11e', 'd93ce117-7073-4f44-b396-858bdd8b7056', '9260be8b-11bd-4799-b19a-8f9b7283e439', 'Ствол 2', '353134', 777, 10, true, 'test 2');


--insert product_j_attribute
insert into attribute_j_product (product_id, attribute_value_id)
values ('2d752d40-aaf1-11ed-afa1-0242ac120002', '3657521c-dd73-4c26-a8f0-1dd570bc1907');
insert into attribute_j_product (product_id, attribute_value_id)
values ('2d752d40-aaf1-11ed-afa1-0242ac120002', 'e2cb2ba4-aaf1-11ed-afa1-0242ac120002');

insert into attribute_j_product (product_id, attribute_value_id)
values ('d39d3c95-eac1-44aa-8d30-b124d2acc11e', 'ef3a280e-aaf1-11ed-afa1-0242ac120002');
insert into attribute_j_product (product_id, attribute_value_id)
values ('d39d3c95-eac1-44aa-8d30-b124d2acc11e', 'ae099b84-46ac-428f-8b22-7c26f05ef77e');
