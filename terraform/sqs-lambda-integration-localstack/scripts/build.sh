#!/bin/bash

rm -rf lambda_function.zip
pushd lambda || exit 1
npm install
npm run build
popd || exit 1

#zip -r lambda_function.zip lambda
#chmod 777 lambda_function.zip