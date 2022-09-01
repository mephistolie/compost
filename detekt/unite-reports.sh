#!/bin/bash
declare -a modules=("core" "ui" "demo")
declare -a names=("Core" "UI" "Demo")
for ((i=0; i < ${#modules[@]}; i++))
do
  printf "\n# %s Static Analysis\n" "${names[i]}" >> static-analysis.md
  touch "${modules[i]}/build/reports/detekt/detekt.md"
  sed -n "2,10000p" "${modules[i]}/build/reports/detekt/detekt.md" >> static-analysis.md
  sed -i '$ d' static-analysis.md
done
