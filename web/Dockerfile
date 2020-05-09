# base image
FROM node:9.6.1 as build

# install chrome for protractor tests
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
RUN apt-get update && apt-get install -yq google-chrome-stable

ENV NPM_CONFIG_PREFIX=~/.npm-global

# set working directory
WORKDIR /app

# add `/usr/src/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY . /app

RUN chown -Rh node:node /app

USER node

RUN npm install --loglevel=warn;
RUN npm install -g @angular/cli@1.7.1

# build
RUN ng build --output-path=dist

FROM nginx:1.16.0-alpine

COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
