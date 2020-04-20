PGDMP     *                     x            postgres    12.2    12.2     ;           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            <           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            =           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            >           1262    13318    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE postgres;
                postgres    false            ?           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    2878                        2615    16980    newspost    SCHEMA        CREATE SCHEMA newspost;
    DROP SCHEMA newspost;
                postgres    false            �            1259    16995    authorities    TABLE     �   CREATE TABLE newspost.authorities (
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL
);
 !   DROP TABLE newspost.authorities;
       newspost         heap    postgres    false    8            �            1259    16983    postdata    TABLE     \   CREATE TABLE newspost.postdata (
    id bigint NOT NULL,
    head text,
    article text
);
    DROP TABLE newspost.postdata;
       newspost         heap    postgres    false    8            �            1259    16981    postdata_id_seq    SEQUENCE     z   CREATE SEQUENCE newspost.postdata_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE newspost.postdata_id_seq;
       newspost          postgres    false    221    8            @           0    0    postdata_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE newspost.postdata_id_seq OWNED BY newspost.postdata.id;
          newspost          postgres    false    220            �            1259    16990    users    TABLE     �   CREATE TABLE newspost.users (
    username character varying(50) NOT NULL,
    password character varying(100) NOT NULL,
    enabled boolean NOT NULL
);
    DROP TABLE newspost.users;
       newspost         heap    postgres    false    8            �
           2604    16986    postdata id    DEFAULT     n   ALTER TABLE ONLY newspost.postdata ALTER COLUMN id SET DEFAULT nextval('newspost.postdata_id_seq'::regclass);
 <   ALTER TABLE newspost.postdata ALTER COLUMN id DROP DEFAULT;
       newspost          postgres    false    220    221    221            8          0    16995    authorities 
   TABLE DATA           <   COPY newspost.authorities (username, authority) FROM stdin;
    newspost          postgres    false    223   �       6          0    16983    postdata 
   TABLE DATA           7   COPY newspost.postdata (id, head, article) FROM stdin;
    newspost          postgres    false    221   �       7          0    16990    users 
   TABLE DATA           >   COPY newspost.users (username, password, enabled) FROM stdin;
    newspost          postgres    false    222   �       A           0    0    postdata_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('newspost.postdata_id_seq', 8, true);
          newspost          postgres    false    220            �
           2606    16994    users users_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY newspost.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);
 <   ALTER TABLE ONLY newspost.users DROP CONSTRAINT users_pkey;
       newspost            postgres    false    222            �
           2606    16998 %   authorities authorities_username_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY newspost.authorities
    ADD CONSTRAINT authorities_username_fkey FOREIGN KEY (username) REFERENCES newspost.users(username);
 Q   ALTER TABLE ONLY newspost.authorities DROP CONSTRAINT authorities_username_fkey;
       newspost          postgres    false    223    2741    222            8      x�s�O���q�wt�������� :b�      6   �   x�5��	�0�'Sd EA�q����vA;���F����m�%*!�w���m�1���
���Ҡ�:�X)`��l׆:j��`�[=M1�vz�pC'gx)��H(b2��R��roJ��y�D:)���='������ey�5[�0�k�ZL�`�×����l)�>���_��      7      x�s�O����/�5426�,����� O��     