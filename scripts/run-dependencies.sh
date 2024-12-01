#!/bin/bash

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# This script specifically doesn't run ollama in a docker conatainer due to docker currently
# not supporting GPUs for Apple Sillicon on Mac. See: https://chariotsolutions.com/blog/post/apple-silicon-gpus-docker-and-ollama-pick-two/#:~:text=Docker%20only%20supports%20native%20Linux,for%20their%20mandatory%20Virtualization%20engine.
echo "🦙 Running Ollama with llama3.2"
if ! brew list "ollama" &>/dev/null; then
    echo "🦙🎯 Ollama is not installed. Installing..."
    brew install "$PACKAGE_NAME"
    brew services restart ollama
    echo "✅ Ollama installed"
else
    echo " Ollama is already installed."
fi
echo "🪄 Starting ollama and model"
ollama run llama3.2 &
echo "✅ Ollama running"

echo "🐳 Running compose file"
docker-compose -f "$SCRIPT_DIR/../compose.yml" up -d
echo "✅ Compose file is running"
