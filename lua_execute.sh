#!/bin/bash

cd src/test/lua

for file in $(ls *)
do
  lua $file
done
